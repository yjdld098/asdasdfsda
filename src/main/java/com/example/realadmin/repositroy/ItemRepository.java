package com.example.realadmin.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.realadmin.system.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findFirstByNameOrderByIdDesc(String name);
}
