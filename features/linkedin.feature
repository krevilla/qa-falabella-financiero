Feature: Prueba linkedin

  Scenario Outline: Login exitoso en linkedin ver perfil de usuario buscar un contacto y cerrar sesion
    Given Abrir el navegador e ir al sitio web linkedin
    When ingresar el username "<loginEmail>" el password "<loginPassword>" 
    And presionar click en el boton entrar para ver perfil
    And presionar click en boton MiRed
    And buscar primer contacto de la lista 
    Then presiona cerrar sesión
  
    Examples: 
      | loginEmail          | loginPassword |
      | position.trello.3@gmail.com | position.trello.3     |
      | position.trello.3@gmail.com | 777777777     |



