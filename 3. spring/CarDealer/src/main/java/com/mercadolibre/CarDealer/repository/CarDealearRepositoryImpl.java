package com.mercadolibre.CarDealer.repository;

import com.mercadolibre.CarDealer.entity.CarEntity;
import com.mercadolibre.CarDealer.entity.ServiceEntity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class CarDealearRepositoryImpl implements ICarDealerRepository{
    @Override
    public void addCar(CarEntity car) {
        List<CarEntity> cars = loadDataBase();
        cars.add(car);
    }

    @Override
    public List<CarEntity> listWithOutServices() {
        return listCarsWithoutServices();
    }

    @Override
    public List<CarEntity> findByDate(Date since, Date to) {
        List<CarEntity> cars = loadDataBase().stream().filter(carEntity -> !carEntity.getManufacturingDate().before(since) && !carEntity.getManufacturingDate().after(to)).toList();
        return cars;
    }

    @Override
    public List<CarEntity> findByPrice(int since,int to) {
        List<CarEntity> cars = loadDataBase().stream().filter(carEntity -> carEntity.getPrice() >= since && carEntity.getPrice() <= to).toList();
        return cars;
    }

    @Override
    public List<CarEntity> findById(int id) {
        List<CarEntity> cars = loadDataBase().stream().filter(carEntity -> carEntity.getId() == id).toList();
        return cars;
    }

    public List<CarEntity> listCarsWithoutServices(){

        ArrayList<CarEntity> cars = new ArrayList<>();
        cars.add(new CarEntity(1,"Toyota", "Corolla", generateManufacturingDate(2020), 30000, 4, 15000, "AR"));
        cars.add(new CarEntity(2,"Honda", "Civic", generateManufacturingDate(2019), 25000, 4, 18000, "AR"));
        cars.add(new CarEntity(3,"Ford", "Focus", generateManufacturingDate(2021), 15000, 4, 20000, "AR"));
        cars.add(new CarEntity(4,"Chevrolet", "Malibu", generateManufacturingDate(2018), 45000, 4, 17000, "AR"));
        cars.add(new CarEntity(5,"Nissan", "Altima", generateManufacturingDate(2022), 8000, 4, 23000, "AR"));
        cars.add(new CarEntity(6,"BMW", "3 Series", generateManufacturingDate(2017), 60000, 4, 25000, "AR"));
        cars.add(new CarEntity(7,"Audi", "A4", generateManufacturingDate(2020), 20000, 4, 30000, "AR"));
        cars.add(new CarEntity(8,"Volkswagen", "Golf", generateManufacturingDate(2019), 35000, 4, 22000, "AR"));
        cars.add(new CarEntity(9,"Hyundai", "Elantra", generateManufacturingDate(2021), 12000, 4, 16000, "AR"));
        cars.add(new CarEntity(10,"Kia", "Optima", generateManufacturingDate(2018), 50000, 4, 14000, "AR"));
        return  cars;
    }


    public List<CarEntity> loadDataBase(){
        ArrayList<ServiceEntity> services = new ArrayList<>();

        services.add(new ServiceEntity(generateDate(2023, 1, 15), 15000, "Cambio de aceite"));
        services.add(new ServiceEntity(generateDate(2023, 2, 20), 20000, "Revisión de frenos"));
        services.add(new ServiceEntity(generateDate(2023, 3, 5), 25000, "Alineación y balanceo"));
        services.add(new ServiceEntity(generateDate(2023, 4, 10), 28000, "Cambio de filtros"));
        services.add(new ServiceEntity(generateDate(2023, 5, 25), 30000, "Revisión de suspensión"));
        services.add(new ServiceEntity(generateDate(2023, 6, 12), 35000, "Limpieza de inyectores"));
        services.add(new ServiceEntity(generateDate(2023, 7, 1), 40000, "Servicio de transmisión"));
        services.add(new ServiceEntity(generateDate(2023, 8, 18), 45000, "Reemplazo de pastillas de freno"));
        services.add(new ServiceEntity(generateDate(2023, 9, 22), 50000, "Cambio de neumáticos"));
        services.add(new ServiceEntity(generateDate(2023, 10, 30), 55000, "Inspección de seguridad"));
        services.add(new ServiceEntity(generateDate(2023, 11, 14), 60000, "Mantenimiento de aire acondicionado"));
        services.add(new ServiceEntity(generateDate(2023, 12, 5), 65000, "Revisión del sistema eléctrico"));
        services.add(new ServiceEntity(generateDate(2024, 1, 6), 70000, "Reemplazo de bomba de agua"));
        services.add(new ServiceEntity(generateDate(2024, 2, 28), 75000, "Cambio de correa de distribución"));
        services.add(new ServiceEntity(generateDate(2024, 3, 15), 80000, "Revisión de temperatura"));
        services.add(new ServiceEntity(generateDate(2024, 4, 10), 85000, "Revisión de aceites de transmisión"));
        services.add(new ServiceEntity(generateDate(2024, 5, 20), 90000, "Limpieza de radiador"));
        services.add(new ServiceEntity(generateDate(2024, 6, 25), 95000, "Cambio de bujías"));
        services.add(new ServiceEntity(generateDate(2024, 7, 15), 100000, "Revisión de cinturones de seguridad"));
        services.add(new ServiceEntity(generateDate(2024, 8, 30), 105000, "Mantenimiento de frenos difusores"));
        services.add(new ServiceEntity(generateDate(2024, 9, 18), 110000, "Revisión de dirección asistida"));


        ArrayList<CarEntity> cars = new ArrayList<>();
                cars.add(new CarEntity(1,"Toyota", "Corolla", generateManufacturingDate(2020), 30000, 4, 15000, "AR",services));
                cars.add(new CarEntity(2,"Honda", "Civic", generateManufacturingDate(2019), 25000, 4, 18000, "AR",services));
                cars.add(new CarEntity(3,"Ford", "Focus", generateManufacturingDate(2021), 15000, 4, 20000, "AR",services));
                cars.add(new CarEntity(4,"Chevrolet", "Malibu", generateManufacturingDate(2018), 45000, 4, 17000, "AR",services));
                cars.add(new CarEntity(5,"Nissan", "Altima", generateManufacturingDate(2022), 8000, 4, 23000, "AR",services));
                cars.add(new CarEntity(6,"BMW", "3 Series", generateManufacturingDate(2017), 60000, 4, 25000, "AR",services));
                cars.add(new CarEntity(7,"Audi", "A4", generateManufacturingDate(2020), 20000, 4, 30000, "AR",services));
                cars.add(new CarEntity(8,"Volkswagen", "Golf", generateManufacturingDate(2019), 35000, 4, 22000, "AR",services));
                cars.add(new CarEntity(9,"Hyundai", "Elantra", generateManufacturingDate(2021), 12000, 4, 16000, "AR",services));
                cars.add(new CarEntity(10,"Kia", "Optima", generateManufacturingDate(2018), 50000, 4, 14000, "AR",services));
        return  cars;
    }
    private static Date generateManufacturingDate(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, Calendar.JANUARY, 1); // Genera una fecha el 1 de enero del año especificado
        return cal.getTime();
    }
    private static Date generateDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day); // Los meses en Calendar son 0-indexados
        return cal.getTime();
    }


}
