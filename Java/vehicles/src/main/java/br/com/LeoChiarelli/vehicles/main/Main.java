package br.com.LeoChiarelli.vehicles.main;

import br.com.LeoChiarelli.vehicles.models.Data;
import br.com.LeoChiarelli.vehicles.models.Models;
import br.com.LeoChiarelli.vehicles.models.Vehicle;
import br.com.LeoChiarelli.vehicles.services.APIConsumption;
import br.com.LeoChiarelli.vehicles.services.ConvertsData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    Scanner scan = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private String url;
    private APIConsumption consumption = new APIConsumption();
    private ConvertsData converter = new ConvertsData();

    public void displayMenu(){
        var menu = """
                **** OPÇÕES ****
                Carro
                Moto
                Caminhão
                
                Digite uma das opções para consultar: """;

        System.out.print(menu);
        var vehicleOption = scan.nextLine();

        if(vehicleOption.toUpperCase().contains("CARRO")){
            url = URL_BASE + "carros/marcas/";
        } else if (vehicleOption.toUpperCase().contains("MOTO")) {
            url = URL_BASE + "motos/marcas/";
        } else {
            url = URL_BASE + "caminhoes/marcas/";
        }

        var json = consumption.getData(url);
        // System.out.println(json);

        var brands = converter.getList(json, Data.class);
        brands.stream()
                .sorted(Comparator.comparing(Data::name))
                .forEach(System.out::println);

        System.out.println("Informe o código da marca para consulta: ");
        var brandCode = scan.nextLine();

        url += brandCode + "/modelos/";
        json = consumption.getData(url);
        var listOfCarModels = converter.getData(json, Models.class);
        System.out.println("Modelos desta marca: ");
        listOfCarModels.models().stream()
                .sorted(Comparator.comparing(Data::name))
                .forEach(System.out::println);

        System.out.println("Informe o nome do carro para busca: ");
        var modelName = scan.nextLine();

        List<Data> filteredModels = listOfCarModels.models().stream()
                .filter(m -> m.name().toUpperCase().contains(modelName.toUpperCase()))
                .collect(Collectors.toList());

        System.out.println("Modelos filtrados: ");
        filteredModels.forEach(System.out::println);

        System.out.println("Informe o código do modelo desejado: ");
        var modelCode = scan.nextLine();

        url += modelCode + "/anos/";
        json = consumption.getData(url);
        List<Data> years = converter.getList(json, Data.class);
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < years.size(); i++) {
            var urlYears = url + years.get(i).code();
            json = consumption.getData(urlYears);
            Vehicle vehicle = converter.getData(json, Vehicle.class);
            vehicles.add(vehicle);
        }

        System.out.println("Todos os veículos filtrados com avaliações por ano: ");
        vehicles.forEach(System.out::println);
    }
}
