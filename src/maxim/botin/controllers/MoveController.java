package maxim.botin.controllers;

import maxim.botin.model.Field;
import maxim.botin.model.Figure;
import maxim.botin.model.exceptions.AlreadyOccupiedException;
import maxim.botin.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    private final Point point;

    private final Field field;

    private final Figure figure;

    public MoveController(final Point point,
                          final Figure figure,
                          final Field field) {
        this.point = point;
        this.figure = figure;
        this.field = field;
    }

    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point) throws InvalidPointException,
                                                      AlreadyOccupiedException {
        if(field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }


}
