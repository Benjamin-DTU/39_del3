package model.undefined;

import model.fields.Field;

public class Board {
    private Field[] fields;
    private Field currentField;

    public Board(Field[] fields, Field currentField) {
        this.fields = fields;
        this.currentField = currentField;
    }

    public Field[] getFields() {
        return fields;
    }
}
