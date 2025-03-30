package com.project.First_project;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {

    String createMenu(Menu menu);
    List<Menu> readMenu();
    boolean deleteMenu(Long id);
    Menu updateMenu(Menu menu , long id);
    Menu getOneItem(Menu menu , long id);
}
