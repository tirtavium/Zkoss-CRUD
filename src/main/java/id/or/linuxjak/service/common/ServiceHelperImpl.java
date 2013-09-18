package id.or.linuxjak.service.common;

import id.or.linuxjak.dao.GenericDao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
@Service("serviceHelper")
public abstract class ServiceHelperImpl<T> implements ServiceHelper<T> {

	@Autowired
	protected GenericDao<T> genericDao;

	@Transactional(readOnly = true)
	public List<T> getAll(Class<T> clazz) {

		return genericDao.getAll(clazz);
	}

	public long countAll(Map<Object, String> param) {

		return 0;
	}

	@Transactional
	public void create(T t) {

		genericDao.create(t);
	}

	@Transactional
	public void delete(T t) {

		genericDao.delete(t);
	}

	@Transactional(readOnly = true)
	public T find(Class<T> clazz, Long id) {

		return genericDao.find(clazz, id);
	}

	@Transactional
	public void update(T t) {

		genericDao.update(t);

	}

}
