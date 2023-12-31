package com.audi.test.myself;

/**
 * User : LinShiYue
 * Date : 2023-12-14 10:06:21
 * Description :
 */

import org.apache.flink.table.annotation.DataTypeHint;
import org.apache.flink.table.annotation.FunctionHint;
import org.apache.flink.table.functions.TableFunction;
import org.apache.flink.types.Row;

@FunctionHint(output = @DataTypeHint("ROW<word STRING, length INT>"))
public class CustomUDTF extends TableFunction<Row> {
    public void eval(String str) {
        for (String s : str.split(" ")) {
            // use collect(...) to emit a row
            collect(Row.of(s, s.length()));
        }
    }
}