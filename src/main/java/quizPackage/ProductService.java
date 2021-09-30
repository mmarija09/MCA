package quizPackage;

import java.util.ArrayList;
import java.util.Comparator;

public class ProductService {

    public static ArrayList<Product> getByDomestic(ArrayList<Product> list, boolean isDomestic) {
        ArrayList<Product> result = new ArrayList<>();

        list.stream()
                .filter((product -> product.getDomestic() == isDomestic))
                .forEach(result::add);

        return result;
    }

    public static void printCost(ArrayList<Product> list) {
        Double cost = list.stream().mapToDouble(Product::getPrice).sum();
        System.out.println(cost);
    }

    public static void sortProductsByNameAlphabetically(ArrayList<Product> list) {
        list.sort(Comparator.comparing(Product::getName));
    }

}
