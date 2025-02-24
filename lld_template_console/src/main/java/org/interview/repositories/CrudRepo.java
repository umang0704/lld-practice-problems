package org.interview.repositories;

import org.interview.entities.BaseEntity;

import java.text.MessageFormat;
import java.util.*;

public abstract class CrudRepo<T,U extends BaseEntity<T>> {
        protected final TreeMap<T, U> storage = new TreeMap<>();

        public void save(U entity) {
            storage.put(entity.getId(), entity);
        }

        public U get(T key) {
            return storage.get(key);
        }

        public void update(U entity) {
            if (storage.containsKey(entity.getId())) {
                storage.put(entity.getId(), entity);
            } else {
                throw new RuntimeException(MessageFormat.format("Entity with key {0} not found.",entity.getId()));
            }
        }

        public void delete(T key) {
            if (storage.containsKey(key)) {
                storage.remove(key);
            } else {
                throw new NoSuchElementException(MessageFormat.format("Entity with key {0} not found.",key));
            }
        }

        public List<U> getAll() {
            return new ArrayList<>(storage.values());
        }
    }

