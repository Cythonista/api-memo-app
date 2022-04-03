package com.memo.app.value

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

import java.time.LocalDateTime

class CardTest extends Specification {
    def 'コンストラクタから値をセットできること'() {
        when:
        def actual = new Card(1, 'hoge', 'fuga', LocalDateTime.of(2022, 1, 1, 0, 0), LocalDateTime.of(2022, 1, 1, 0, 0), false)

        then:
        actual.cardId == 1
        actual.cardName == 'hoge'
        actual.overview == 'fuga'
        actual.insertTime == LocalDateTime.of(2022, 1, 1, 0, 0)
        actual.updatedTime == LocalDateTime.of(2022, 1, 1, 0, 0)
        actual.deleteFlag == false
    }

    def 'getterから値を取得できること'() {
        when:
        def actual = new Card(1, 'hoge', 'fuga', LocalDateTime.of(2022, 1, 1, 0, 0), LocalDateTime.of(2022, 1, 1, 0, 0), false)

        then:
        actual.getCardId() == 1
        actual.getCardName() == 'hoge'
        actual.getOverview() == 'fuga'
        actual.getInsertTime() == LocalDateTime.of(2022, 1, 1, 0, 0)
        actual.getUpdatedTime() == LocalDateTime.of(2022, 1, 1, 0, 0)
        actual.getDeleteFlag() == false
    }

    def 'jsonシリアライズできること'() {
        when:
        def testObject = new Card(1, 'hoge', 'fuga', LocalDateTime.of(2022, 1, 1, 0, 0), LocalDateTime.of(2022, 1, 1, 0, 0), false)
        def mapper = new ObjectMapper()
        def actual = mapper.writeValueAsString(testObject)

        def expected = '''{"cardId":1,"cardName":"hoge","overview":"fuga","insertTime":[2022,1,1,0,0],"updatedTime":[2022,1,1,0,0],"deleteFlag":false}'''

        then:
        actual == expected
    }
}
