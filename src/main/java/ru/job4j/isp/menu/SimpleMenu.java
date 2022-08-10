package ru.job4j.isp.menu;

import ru.job4j.isp.menu.interfaces.ActionDelegate;
import ru.job4j.isp.menu.interfaces.Menu;
import ru.job4j.isp.menu.interfaces.MenuItem;

import java.util.*;

public class SimpleMenu implements Menu {

    private final List<MenuItem> rootElements = new ArrayList<>();


    /*
        2. На основе метода findItem() реализуйте методы add() и select().
     */

    @Override
    public boolean add(String parentName, String childName, ActionDelegate actionDelegate) {
        return false;
    }
/*
5. Допишите тесты на метод select() и на вывод.
 */


    @Override
    public Optional<MenuItemInfo> select(String itemName) {
        return null;
    }
    /*
    3. Также на основе существующего итератора реализуйте метод iterator()
    */


    @Override
    public Iterator<MenuItemInfo> iterator() {
        return null;
    }

    /*
    1. Реализуйте поиск в методе findItem() на основе DFS итератора.
    2. На основе метода findItem() реализуйте методы add() и select().

     */

    private Optional<ItemInfo> findItem(String name) {
        return null;
    }

    private static class SimpleMenuItem implements MenuItem {

        private String name;
        private List<MenuItem> children = new ArrayList<>();
        private ActionDelegate actionDelegate;

        public SimpleMenuItem(String name, ActionDelegate actionDelegate) {
            this.name = name;
            this.actionDelegate = actionDelegate;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public List<MenuItem> getChildren() {
            return children;
        }

        @Override
        public ActionDelegate getActionDelegate() {
            return actionDelegate;
        }
    }

    private class DFSIterator implements Iterator<ItemInfo> {

        Deque<MenuItem> stack = new LinkedList<>();

        Deque<String> numbers = new LinkedList<>();

        DFSIterator() {
            int number = 1;
            for (MenuItem item : rootElements) {
                stack.addLast(item);
                numbers.addLast(String.valueOf(number++).concat("."));
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public ItemInfo next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            MenuItem current = stack.removeFirst();
            String lastNumber = numbers.removeFirst();
            List<MenuItem> children = current.getChildren();
            int currentNumber = children.size();
            for (var i = children.listIterator(children.size()); i.hasPrevious(); ) {
                stack.addFirst(i.previous());
                numbers.addFirst(lastNumber.concat(String.valueOf(currentNumber--)).concat("."));
            }
            return new ItemInfo(current, lastNumber);
        }

    }

    private class ItemInfo {

        MenuItem menuItem;
        String number;

        public ItemInfo(MenuItem menuItem, String number) {
            this.menuItem = menuItem;
            this.number = number;
        }
    }

}
