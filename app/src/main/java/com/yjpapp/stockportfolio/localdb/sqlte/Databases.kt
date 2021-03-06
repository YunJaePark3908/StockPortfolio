package com.yjpapp.stockportfolio.localdb.sqlte

object Databases {
    /**
     * table name
     */
    const val TABLE_MY_STOCK: String = "my_stock_table"
    const val TABLE_INCOME_NOTE: String = "income_note_table"
    const val TABLE_MEMO: String = "memo_table"

    /**
     * my_stock_table columns
     */
    const val COL_MY_STOCK_ID: String = "id" // primary key, id
    const val COL_MY_STOCK_SUBJECT_NAME: String = "subject_name" // 종목명
    const val COL_MY_STOCK_REAL_GAINS_LOSSES_AMOUNT: String = "real_gains_losses_amount" // 순손익금액
    const val COL_MY_STOCK_GAIN_PERCENT: String = "gain_percent" // 수익률
    const val COL_MY_STOCK_PURCHASE_DATE: String = "purchase_date" //매수일
    const val COL_MY_STOCK_PURCHASE_PRICE: String = "purchase_price" //매수단가
//    const val COL_MY_STOCK_GAIN_PERCENT: String = "gain_percent" // 수익률
    const val COL_MY_STOCK_CURRENT_PRICE: String = "current_price" // 현재가
    const val COL_MY_STOCK_PURCHASE_COUNT: String = "purchase_count" // 매도수량

    /**
     * memo_table columns
     */
    const val COL_MEMO_ID: String = "id" //primary key, id
    const val COL_MEMO_DATE: String = "date" //날짜
    const val COL_MEMO_TITLE: String = "title" //제목
    const val COL_MEMO_CONTENT: String = "content" //내용
    const val COL_MEMO_DELETE_CHECK: String = "delete_check" //삭제 체크

    /**
     * portfolio_table columns
     */
    const val COL_INCOME_NOTE_ID: String = "id" // primary key, id
    const val COL_INCOME_NOTE_SUBJECT_NAME: String = "subject_name" // 종목명
    const val COL_INCOME_NOTE_REAL_GAINS_LOSSES_AMOUNT: String = "real_gains_losses_amount" // 순손익금액
    const val COL_INCOME_NOTE_PURCHASE_DATE: String = "purchase_date" //매수일
    const val COL_INCOME_NOTE_SELL_DATE: String = "sell_date" // 매도일
    const val COL_INCOME_NOTE_PURCHASE_PRICE: String = "purchase_price" //매수단가
    const val COL_INCOME_NOTE_SELL_PRICE: String ="sell_price" //매도단가
    const val COL_INCOME_NOTE_GAIN_PERCENT: String = "gain_percent" // 수익률
    const val COL_INCOME_NOTE_SELL_COUNT: String = "sell_count" // 매도수량

}