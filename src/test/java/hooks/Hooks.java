package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void initializeTestData() {
        System.out.println("Before");
        // Aquí podrías inicializar la base de datos de pruebas o cualquier otro recurso necesario para las pruebas
    }

    @After
    public void cleanupTestData() {
        System.out.println("after");
        // Aquí podrías limpiar cualquier recurso utilizado durante las pruebas
    }
}
