# exploring-mars

Desafio técnico do Elo7. 

### Considerações

Usei as coordenadas do planalto para limitar os movimentos das sondas. Caso alguma sonda ultrapasse esse limite, o programa lançará uma exceção antes de realizar a movimentação deixando a sonda sempre no limite do planalto.

### Testes

Criei uma API Rest para realizar os testes no programa. Possui apenas um endpoint.

* [POST] - /probes : O conteúdo da request deve conter os dados de entrada como na especificação no seguinte formato:

```
{
    "plateau": { 
        "coordinates": "5 5"
    },
    "spaceProbes": [
        {
            "coordinates": "1 2",
            "direction": "N",
            "instructions": "LMLMLMLMM"
        },
        {
            "coordinates": "3 3",
            "direction": "E",
            "instructions": "MMRMMRMRRM"
        }
    ]
}
```

A resposta será uma lista com as posições das sondas na mesma ordem que foram informadas:
```
[
  {
    "position": "1 3 N"
  },
  {
    "position": "5 1 E"
  }
]
```
