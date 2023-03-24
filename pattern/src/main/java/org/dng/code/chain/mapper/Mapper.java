package org.dng.code.chain.mapper;


@FunctionalInterface
public interface Mapper<T> {
	T map(T s);
}
