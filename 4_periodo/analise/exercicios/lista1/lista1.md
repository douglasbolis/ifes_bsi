# Lista 1

## 1 ) Liste as possíveis classes com base no minimundo, referente a Objetos, Eventos e Agentes;

### Possíveis classes e atributos:

#### Restaurante
#### Processos internos(realização de atendimento e elaboração de pedidos)
#### Cadastro de mesas
1. situação cheia (esperando pedidos, ou não)
2. Vazias (reservada para algum cliente
específico ou não)
#### Cadastro de produtos
#### Cadastro de funcionários:
1. Gerentes, garçons e cozinheiros.
#### Turnos de trabalhos(Diurno ou Noturno)
#### Reservas de mesas
1. Reservadas pelo gerente(2h no máximo), também desfaz reservas.
2. Na reserva da mesa, o cliente deve informar seu nome e telefone.
#### Cadastro de pedidos
1. Garçons realizam pedidos de uma mesa registrando o produto e a
quantidade desejada pelo cliente naquela mesa, se tornando responsável por tal pedido.
2. Apenas é possível registrar pedidos para mesas não reservadas.
3. Não há distinção entre os clientes de uma mesma mesa.
4. Todos os pedidos realizados por ela farão parte de uma mesma comanda.
5. O pedido realizado é referente a um ou mais produtos.
6. Pedidos podem estar pendentes, em elaboração, prontos, entregues ou
pagos.

#### Garçons podem
1. listar pedidos realizados em uma Mesa
2. consultar suas informações
3. cancelar um pedido que ainda não começou a ser elaborado.
4. Ao consultar um pedido, o garçom consegue consultar informações do produto referente.

#### Cozinheiros trabalham
1. elaboração dos pedidos.
2. Eles visualizam a lista de pedidos pendentes no restaurante
3. retiram algum dos pedidos para elaboração.
4. Cozinheiros podem estar esperando pedido ou elaborando pedido.
5. Eles podem elaborar no máximo três pedidos ao mesmo tempo
6. apenas um cozinheiro pode retirar um pedido para elaboração.
7. Depois que o pedido é elaborado, o cozinheiro registra o término da elaboração, tornando o pedido pronto.

#### Os produtos possuem
1. um tempo médio e um tempo máximo de elaboração.
2. Caso o tempo de elaboração do cozinheiro ultrapasse o tempo máximo estipulado para o produto, ele é alertado.

#### Garçons visualizam
1. os pedidos prontos
2. realizam entregas dos mesmos nas mesas, de preferência, entregando pedidos que eles mesmo registraram.

#### Na hora do pagamento
1. os garçons calculam o total da mesa (podendo considerar os 10% ou não) e registram o pagamento dos pedidos dela, registrando-os como pagos
2. O pagamento pode ser realizado por meio de dinheiro ou cartão.
3. No caso do pagamento em dinheiro, o garçom calcula o troco
4. já no pagamento em cartão, o caixa registra o número do mesmo, bem como data de vencimento.

### Pedido
#### durante realização do pedido até a elaboração e entrega do mesmo, algumas estatísticas são realizadas
1. para se saber o tempo médio para iniciar elaboração pelo cozinheiro
2. tempo médio de elaboração
3. de entrega pelo garçom
4. também o tempo total(desde a realização do pedido até sua entrega).