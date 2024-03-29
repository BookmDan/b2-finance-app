package com.b2.b2data.service;

import com.b2.b2data.domain.Element;
import com.b2.b2data.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Provides services for handling {@link Element} objects
 */
@Service
public class ElementService {

    private final ElementRepository REPO;

    /**
     * Constructs a new element service
     *
     * @param repo An element repository
     */
    @Autowired
    public ElementService(ElementRepository repo) {
        REPO = repo;
    }

    /**
     * Finds the element with the given id
     *
     * @param id An element id
     * @return The element with the given id, or null if it does not exist
     */
    public Element findById(Integer id) {
        return REPO.findById(id).orElse(null);
    }

    /**
     * Finds the element with the given number
     *
     * @param number An element number
     * @return The element with the given number, or null if it does not exist
     */
    public Element findByNumber(Integer number) {
        return REPO.findByNumber(number).orElse(null);
    }

    /**
     * Finds the element with the given name
     *
     * @param name An element name
     * @return The element with the given name, or null if it does not exist
     */
    public Element findByName(String name) {
        return REPO.findByName(name).orElse(null);
    }

    /**
     * Finds all elements
     *
     * @return A list of elements sorted by number ascending
     */
    public List<Element> findAll() {
        return REPO.findAllByOrderByNumberAsc();
    }

    /**
     * Saves the given element to the database
     *
     * @param element An element to save
     * @return The element saved in the database
     */
    @Transactional
    @Modifying
    public Element save(Element element) {
        return REPO.save(element);
    }

    /**
     * Deletes the given element from the database
     *
     * @param element An element to delete
     */
    @Transactional
    @Modifying
    public void delete(Element element) {
        REPO.delete(element);
    }
}
