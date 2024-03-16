package com.example.realadmin.repositorytest;

import com.example.realadmin.repositroy.CategoryRepository;
import com.example.realadmin.system.Category;
import com.example.realadmin.system.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends StudyApplicationTests {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create() {
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createBy);

        Category newCategory = categoryRepository.save(category); // 새로 DB에 들어간 category를 반환함

        Assertions.assertNotNull(newCategory);
        Assertions.assertEquals(newCategory.getType(), type);
        Assertions.assertEquals(newCategory.getTitle(), title);
    }

    @Test
    public void read(){
        String type = "COMPUTER";

        Optional<Category> optionalCategory = categoryRepository.findByType(type);
        //select * from category where type = 'COMPUTER'
        optionalCategory.ifPresent(c -> {
            Assertions.assertEquals(c.getType(), type);
            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());
        });

    }
}
