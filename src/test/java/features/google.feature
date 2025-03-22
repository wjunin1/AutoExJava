Feature: Validar acesso ao google

  Scenario: Acesso ao google
    Given acesso o site do google
    When o campo de busca fica visivel
    Then o titulo da página é google
