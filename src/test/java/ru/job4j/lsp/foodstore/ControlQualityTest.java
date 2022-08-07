package ru.job4j.lsp.foodstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.lsp.foodstore.model.Food;
import ru.job4j.lsp.foodstore.model.Groceries;
import ru.job4j.lsp.foodstore.model.Meat;
import ru.job4j.lsp.foodstore.model.Milk;
import ru.job4j.lsp.foodstore.storages.Shop;
import ru.job4j.lsp.foodstore.storages.Store;
import ru.job4j.lsp.foodstore.storages.Trash;
import ru.job4j.lsp.foodstore.storages.Warehouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class ControlQualityTest {
    private  ControlQuality controlQuality;
    private Food macaroni;
    private Food yoghurt;
    private Food chickenNugget;
    private Food oldYoghurt;
    private Food beans;
    private Store shop;
    private Store warehouse;
    private Store trash;

    @Before
    public void initControlQualityObject() {
        shop = new Shop();
        warehouse = new Warehouse();
        trash = new Trash();
        List<Store> testListStorages = new ArrayList<>(List.of(shop, warehouse, trash));
        controlQuality = new ControlQuality(testListStorages);
    }

    @Before
    public void createTestFoodObjects() {
        macaroni = new Groceries("Makfa", LocalDate.now().minusMonths(7),
                LocalDate.now().plusMonths(3), 9.99, 3);
        yoghurt = new Milk("Chudo",
                LocalDate.now(), LocalDate.now().plusMonths(1),
                3.0, 1);
        chickenNugget = new Meat("Petelinka",
                LocalDate.now().minusMonths(7), LocalDate.now().plusMonths(12),
                5.5, 2);
        oldYoghurt = new Milk("DamnWhatASmell",
                LocalDate.now().minusMonths(2), LocalDate.now().minusMonths(1),
                0.35, 0);
        beans = new Groceries("UncleBeanGoods",
                LocalDate.now().minusMonths(6), LocalDate.now().plusMonths(1),
                6.50, 3);
    }


    @Test
    public void whenTrash() {
        controlQuality.addFood(oldYoghurt);
        List<Food> actual = trash.getStore();
        List<Food> expected = List.of(oldYoghurt);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whenWarehouse() {
        controlQuality.addFood(beans);
        List<Food> actual = warehouse.getStore();
        List<Food> expected = List.of(beans);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whenShop() {
        controlQuality.addFood(macaroni);
        controlQuality.addFood(chickenNugget);
        List<Food> actual = shop.getStore();
        List<Food> expected = List.of(macaroni, chickenNugget);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whenWithNewPrice() {
        controlQuality.addFood(yoghurt);
        List<Food> actual = shop.getStore();
        double newPrice = actual.get(0).getPrice();
        System.out.println(actual.get(0).getPrice());
        Assert.assertEquals((int) newPrice, (int) 2.0);
    }

    @Test
    public void whenAllAdded() {
        controlQuality.addFood(macaroni);
        controlQuality.addFood(chickenNugget);
        controlQuality.addFood(oldYoghurt);
        controlQuality.addFood(beans);
        List<Food> actualShop = shop.getStore();
        List<Food> actualWarehouse = warehouse.getStore();
        List<Food> actualTrash = trash.getStore();
        List<Food> expectedShop = List.of(macaroni, chickenNugget);
        List<Food> expectedWarehouse = List.of(beans);
        List<Food> expectedTrash = List.of(oldYoghurt);
        Assert.assertEquals(expectedShop, actualShop);
        Assert.assertEquals(expectedWarehouse, actualWarehouse);
        Assert.assertEquals(expectedTrash, actualTrash);

    }
    @Test
    public void whenResortTest() {
        controlQuality.addFood(macaroni);
        controlQuality.addFood(chickenNugget);
        controlQuality.addFood(oldYoghurt);
        controlQuality.addFood(beans);
        controlQuality.resort();
        List<Food> actualShop = shop.getStore();
        List<Food> actualWarehouse = warehouse.getStore();
        List<Food> actualTrash = trash.getStore();
        List<Food> expectedShop = List.of(macaroni, chickenNugget);
        List<Food> expectedWarehouse = List.of(beans);
        List<Food> expectedTrash = List.of(oldYoghurt);
        Assert.assertEquals(expectedShop, actualShop);
        Assert.assertEquals(expectedWarehouse, actualWarehouse);
        Assert.assertEquals(expectedTrash, actualTrash);

    }


}