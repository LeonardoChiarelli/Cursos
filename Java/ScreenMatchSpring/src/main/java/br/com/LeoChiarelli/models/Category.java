package br.com.LeoChiarelli.models;

public enum Category {
    ACTION("Action", "Ação", "Acao"),
    ROMANCE("Romance", "Romance", "Romance"),
    COMEDY("Comedy", "Comédia", "Comedia"),
    DRAMA("Drama", "Drama", "Drama"),
    CRIME("Crime", "Crime", "Crime");

    private String categoryOmdb;
    private String categoryPortuguese;
    private String categoryWithoutAccent;

    Category(String categoryOmdb, String categoryPortuguese, String categoryWithoutAccent){
        this.categoryOmdb = categoryOmdb;
        this.categoryPortuguese = categoryPortuguese;
        this.categoryWithoutAccent = categoryWithoutAccent;
    }

    public static Category fromString(String text){
        for (Category category : Category.values()){
            if(category.categoryOmdb.equalsIgnoreCase(text)){
                return category;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encotrada para a string fornecida: " + text);
    }

    public static Category fromPortuguese(String text){
        for (Category category : Category.values()){
            if(category.categoryPortuguese.equalsIgnoreCase(text)){
                return category;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encotrada para a string fornecida: " + text);
    }

    public static Category withouAceent(String text){
        for (Category category : Category.values()){
            if(category.categoryWithoutAccent.equalsIgnoreCase(text)){
                return category;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
