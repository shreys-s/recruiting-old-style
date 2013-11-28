package it.f2informatica.services.gateway;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.Set;

public abstract class EntityToModelConverter<S, T> implements Converter<S, T> {

	public List<T> convertList(List<S> sourceList) {
		return Lists.newArrayList(convertIterable(sourceList));
	}

	public Set<T> convertSet(Set<S> sourceSet) {
		return Sets.newHashSet(convertIterable(sourceSet));
	}

	public Iterable<T> convertIterable(Iterable<S> sourceIterable) {
		return Iterables.transform(sourceIterable,
			new Function<S, T>() {
				@Override
				public T apply(S source) {
					return convert(source);
				}
			}
		);
	}

}
