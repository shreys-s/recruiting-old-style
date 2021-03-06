/*
 * =============================================================================
 *
 *   Copyright (c) 2014, Fernando Aspiazu
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package it.f2informatica.pagination.repository.mongodb;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.io.Serializable;
import java.util.List;

public class SimpleMongoPaginationRepository<T, ID extends Serializable>
	extends SimpleMongoRepository<T, ID> implements MongoDBQueryExecutor<T> {

	public SimpleMongoPaginationRepository(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
	}

	@Override
	public List<T> findAll(MongoQueryPredicate<T> predicate) {
		return getMongoOperations().findAll(predicate.getEntityClass());
	}

	@Override
	public Page<T> findAll(MongoQueryPredicate<T> predicate, Pageable pageable) {
		List<T> content = getMongoOperations().find(predicate.queryPredicate().with(pageable), predicate.getEntityClass());
		return new PageImpl<>(content, pageable, getMongoOperations().count(predicate.queryPredicate(), predicate.getEntityClass()));
	}

}
