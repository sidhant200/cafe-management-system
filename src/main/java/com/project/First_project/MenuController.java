package com.project.First_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping("menu")
    public List<Menu> getAllMenu(){
        return menuService.readMenu();
    }

    @PostMapping("menu")
    public String createMenu(@RequestBody Menu menu){
         return menuService.createMenu(menu);
    }

    @DeleteMapping("menu/{id}")
    public String deleteMenu(@PathVariable long id){
        menuService.deleteMenu(id);
        return "menu deleted";

    }

    @PutMapping ("menu/{id}")
    public String updateMenu(@RequestBody Menu menu , @PathVariable long id){
        menuService.updateMenu(menu , id);
        return "updated succesfully";
    }

    @GetMapping("menu/{id}")
    public Menu getOneItem(@RequestBody Menu menu , @PathVariable long id){
        return menuService.getOneItem(menu , id);
    }





}
