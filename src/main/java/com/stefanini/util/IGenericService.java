package com.stefanini.util;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.stefanini.model.Pessoa;

public interface IGenericService<T, I extends Serializable> {

	/**
	 * Salvar uma entidade
	 * @param entity
	 * @return
	 */
	T salvar(@Valid T entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	T atualizar(@Valid T entity);

	void remover(I id);

	Optional<List<T>> getList();

	Optional<T> encontrar(I id);

}
