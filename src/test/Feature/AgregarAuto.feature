Feature: Add Car
  As admin,
  I want to add new Auto to the inventory
  To be able to keep track of the number of cars in each dealership

  Rule: In order to add a car to the system, a dealership must first exist

    Background:
      Given a new dealership
      When we enter Name: "Fiat"
      And Addres: "Av.Cordoba 2000"
      And was inagurated in "1990"
      And has 200 employees
      Then dealership data is saved in slot "1"

    Scenario: Add a first car
      Given a dealership
      When I want add a new card, model: "Cronos", number of seats: "5", maximum speed: "150" km/h, a stock of: "10" cars
      And I selected a dealership "1"
      Then the card is saved in slot 1 of dealership 1

    Scenario: Add a second car
      Given a dealership
      When I want add a new card, model: "Argo", number of seats: "5", maximum speed: "120" km/h, a stock of: "20" cars
      And I selected a dealership "1"
      Then the card is saved in slot 2 of dealership 1

    Scenario: Add a new car in wrong dealership
      Given a dealership
      When I want add a new card, model: "Toro", number of seats: "5", maximum speed: "200" km/h, a stock of: "5" cars
      And I selected a dealership "2"
      Then the card is not saved in dealership 2
      And show the message "No existe concecionaria, auto descartado."

      Scenario: Add a new car whit 0 stock
        Given a dealership
        When I want add a new card, model: "Siena", number of seats: "5", maximum speed: "100" km/h, a stock of: "0" cars
        And I selected a dealership "1"
        Then the card is not saved in dealership 1
        And show the message "El Stock debe ser mayo a 0."

    Scenario: Add a new car whit alphanumeric characters
      Given a dealership
      When I want add a new card, model: "Mobi", number of seats: "HolaMundo", maximum speed: "#QARULES123" km/h, a stock of: "#@$%$^" cars
      Then show the message "Debes ingresar un numero."
