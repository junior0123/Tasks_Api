Feature: Iniciar sesión
  Como usuario
  Quiero poder iniciar sesión en la aplicación
  Para acceder a mi cuenta personal

  Scenario: Iniciar sesión con credenciales válidas
    Given estoy en la página de inicio de sesión
    When ingreso mi nombre de usuario "johndoe" y mi contraseña "password"
    And hago clic en el botón "Iniciar sesión"
    Then debo ser redirigido a la página principal
    And debo ver un mensaje de bienvenida "Bienvenido, John Doe"
