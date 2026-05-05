## Plano de Testes

| ID  | Operação              | Entrada              | Resultado Esperado           | Resultado Obtido     | Status      |
|-----|----------------------|---------------------|------------------------------|----------------------|------------|
| T01 | Soma                 | 2 + 3               | 5                            | 5.0                  | ✅ Passou  |
| T02 | Subtração            | 5 - 2               | 3                            | 3.0                  | ✅ Passou  |
| T03 | Multiplicação        | 4 * 3               | 12                           | 12.0                 | ✅ Passou  |
| T04 | Divisão              | 10 / 2              | 5                            | 5.0                  | ✅ Passou  |
| T05 | Divisão por zero     | 10 / 0              | Erro (ArithmeticException)   | ArithmeticException  | ✅ Passou  |
| T06 | Números negativos    | -2 + 3              | 1                            | 1.0                  | ✅ Passou  |
| T07 | Números decimais     | 2.5 * 2             | 5.0                          | 5.0                  | ✅ Passou  |
| T08 | Subtração negativa   | 2 - 5               | -3                           | -3.0                 | ✅ Passou  |
| T09 | Números grandes      | 999999 * 999999     | 999998000001.0               | 999998000001.0       | ✅ Passou  |
| T10 | Zero em operações    | 0 + 0               | 0                            | 0.0                  | ✅ Passou  |

## Passo a Passo para Execução dos Testes

1. Abra o projeto na sua IDE (como Eclipse ou IntelliJ).

2. Navegue até a pasta:

   ```
   Aprendendo_Testes_De_Sistemas
   ```

3. Em seguida, entre na subpasta:

   ```
   Teste_JUNIT
   ```

4. Localize a classe:

   ```
   TestCalculo
   ```

5. Abra a classe de testes `TestCalculo`.

6. Execute os testes unitários um por vez para validar cada regra implementada:

   * Teste de soma
   * Teste de subtração
   * Teste de multiplicação
   * Teste de divisão
   * Teste de divisão por zero
   * Teste com números negativos
   * Teste com números decimais
   * Teste de subtração com resultado negativo
   * Teste com números grandes
   * Teste com zero

7. Verifique se o resultado obtido em cada teste corresponde ao resultado esperado.

8. Confirme se todos os testes estão passando (status ✅).

9. Caso algum teste falhe, revise a lógica da operação correspondente na classe de cálculo.

## Observação

Executar os testes individualmente ajuda a identificar com precisão possíveis erros em regras específicas do sistema.
