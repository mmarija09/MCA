package quizPackage;

public class Product {

    private String description;
    private Boolean domestic;
    private String name;
    private Double price;
    private Long weight;

    public Product(String description, Boolean domestic, String name, Double price, Long weight) {
        this.description = description;
        this.domestic = domestic;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDomestic() {
        return domestic;
    }

    public void setDomestic(Boolean domestic) {
        this.domestic = domestic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String toString() {
        String description = (this.description.length() > 10) ? this.description.substring(0, 10) : this.description;
        String weight = (this.weight != null) ? this.weight.toString() + "g" : "N/A";

        return  "..." + this.getName() + "\n"
                + "   Price: $" + this.getPrice() + "\n"
                + "   " + description +  "..." + "\n"
                + "   Weight: " + weight ;

    }
}
