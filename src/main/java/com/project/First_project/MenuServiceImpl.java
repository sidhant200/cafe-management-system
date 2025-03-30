package com.project.First_project;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuRepository menuRepository;


    @Override
    public String createMenu(Menu menu) {
        MenuEntity menuEntity = new MenuEntity();
        BeanUtils.copyProperties(menu , menuEntity);
        menuRepository.save(menuEntity);
        return "saved succesfull";
    }

    @Override
    public List<Menu> readMenu() {
        List<MenuEntity> menuEntities  = menuRepository.findAll();
        List<Menu> menus = new ArrayList<>();
        for (MenuEntity  menuEntity : menuEntities){
            Menu menu = new Menu();
            menu.setId(menuEntity.getId());
            menu.setPrice(menuEntity.getPrice());
            menu.setItemName(menuEntity.getItemName());
            menus.add(menu);
        }
        return menus;
    }

    @Override
    public boolean deleteMenu(Long id) {
        menuRepository.deleteById(id);
        return true;
    }

    @Override
    public Menu updateMenu(Menu menu, long id) {
        MenuEntity menuEntity = menuRepository.findById(id).get();
        menuEntity.setItemName(menu.getItemName());
        menuEntity.setPrice(menu.getPrice());
        menuRepository.save(menuEntity);
        return null;
        }

    @Override
    public Menu getOneItem(Menu menu, long id) {
      MenuEntity menuEntity = menuRepository.findById(id).get();
      Menu menu1 = new Menu();
      menu1.setItemName(menuEntity.getItemName());
      menu1.setPrice(menuEntity.getPrice());
      return menu1;
    }

}
