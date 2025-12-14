package br.com.LeoChiarelli.screenSoundSpring.models;

public enum ArtistCategory {
    SOLO("SOLO"),
    DUO("DUPLA"),
    BAND("BANDA");

    private final String artistCategoryPortuguese;

    ArtistCategory(String artistCategoryPortuguese){
        this.artistCategoryPortuguese = artistCategoryPortuguese;
    }

    public static ArtistCategory fromPortuguse(String text){
        for (ArtistCategory category: ArtistCategory.values()){
            if(category.artistCategoryPortuguese.equalsIgnoreCase(text)){
                return category;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string: " + text);
    }
}
