@parallel=false
Feature: Pruebas APIS TARJETA VISA

  Background: 
    * url baseURL
    * def collection = Java.type('collection.utility.purchaseNum')
    * def req = Java.type('collection.api.Mpp')

	@demo
  Scenario Outline: <CP> -<Descripcion>
    Given path <comercio>
    And collection.flag('<flag>','<comercio>')
    * def data = req.data('<numCP>')
    * def purchase = collection.getNumber()
    * set data.order.purchaseNumber = purchase
    And request data
    And print data
    When method POST
    Then status <status>
    And print response
    And match $.header.ecoreTransactionUUID == "#uuid"
    And match $.header.ecoreTransactionDate == "#regex \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?(Z|[-+]\\d{2}:\\d{2})?"
    And match $.responseCode == '<responseCode>'
    And match $.responseMessage == '<responseMessage>'
    And match $.order.purchaseNumber == purchase
    And match $.order.amount == <order.amount>
    And match $.order.currency == '<order.currency>'
    And match $.order.externalTransactionId == '#string'
    And match $.order.statusIdentifier == '#string'
    And match $.order.transactionIdentifier == '#string'
    And match $.order.retrievalReferenceNumber == '#string'
    And match $.order.actionCode == '<order.actionCode>'
    And match $.order.approvalCode == '#string'
    And match $.order.responseCode == '<order.responseCode>'
    And match $.order.transmissionDateTime == "#regex \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?(Z|[-+]\\d{2}:\\d{2})?"
    And match $.order.brand == '#string'
    And match $.order.binRecipient == '#string'
    And match $.dataMap.comisionVisanet == '<comisionVisanet>'
    And match $.dataMap.balance == '#string'
    And match $.dataMap.igv == '<igv>'
    And match $.dataMap.totalVisanet == '<totalVisanet>'
    And match $.dataMap.debit == '<debit>'

    Examples: 
      | read(ruta).slice(0, 1) |

  Scenario Outline: <CP> -<Descripcion>
    Given path <comercio>
    And collection.flag('<flag>','<comercio>')
    * def data = req.data('<numCP>')
    * def purchase = collection.getNumber()
    * set data.order.purchaseNumber = purchase
    And request data
    And print data
    When method POST
    Then status <status>
    And print response
    And match $.header.ecoreTransactionUUID == "#uuid"
    And match $.header.ecoreTransactionDate == "#regex \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?(Z|[-+]\\d{2}:\\d{2})?"
    And match $.responseCode == '<responseCode>'
    And match $.responseMessage == '<responseMessage>'
    And match $.order.purchaseNumber == purchase
    And match $.order.amount == <order.amount>
    And match $.order.currency == '<order.currency>'
    And match $.order.externalTransactionId == '#string'
    And match $.order.statusIdentifier == '#string'
    And match $.order.transactionIdentifier == '#string'
    And match $.order.retrievalReferenceNumber == '#string'
    And match $.order.actionCode == '<order.actionCode>'
    And match $.order.responseCode == '<order.responseCode>'
    And match $.order.transmissionDateTime == "#regex \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?(Z|[-+]\\d{2}:\\d{2})?"
    And match $.order.brand == '#string'
    And match $.order.binRecipient == '#string'
    And match $.dataMap.comisionVisanet == '<comisionVisanet>'
    And match $.dataMap.balance == '#string'
    And match $.dataMap.igv == '<igv>'
    And match $.dataMap.totalVisanet == '<totalVisanet>'
    And match $.dataMap.debit == '<debit>'

    Examples: 
      | read(ruta).slice(1, 2) |

  Scenario Outline: <CP> -<Descripcion>
    Given path <comercio>
    And collection.flag('<flag>','<comercio>')
    * def data = req.data('<numCP>')
    * def purchase = collection.getNumber()
    * set data.order.purchaseNumber = purchase
    And request data
    And print data
    When method POST
    Then status <status>
    And print response
    And match $.header.ecoreTransactionUUID == "#uuid"
    And match $.header.ecoreTransactionDate == "#regex \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?(Z|[-+]\\d{2}:\\d{2})?"
    And match $.responseCode == '<responseCode>'
    And match $.responseMessage == '<responseMessage>'
    And match $.order.purchaseNumber == purchase
    And match $.order.amount == <order.amount>
    And match $.order.currency == '<order.currency>'
    And match $.order.externalTransactionId == '#string'
    And match $.order.statusIdentifier == '#string'
    And match $.order.transactionIdentifier == '#string'
    And match $.order.retrievalReferenceNumber == '#string'
    And match $.order.actionCode == '<order.actionCode>'
    And match $.order.approvalCode == '#string'
    And match $.order.responseCode == '<order.responseCode>'
    And match $.order.transmissionDateTime == "#regex \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?(Z|[-+]\\d{2}:\\d{2})?"
    And match $.order.brand == '#string'
    And match $.order.binRecipient == '#string'
    And match $.dataMap.comisionVisanet == '<comisionVisanet>'
    And match $.dataMap.balance == "#string"
    And match $.dataMap.igv == '<igv>'
    And match $.dataMap.totalVisanet == '<totalVisanet>'
    And match $.dataMap.debit == '<debit>'

    Examples: 
      | read(ruta).slice(2, 3) |

