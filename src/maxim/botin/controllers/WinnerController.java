package maxim.botin.controllers;

import maxim.botin.model.Field;
import maxim.botin.model.Figure;
import maxim.botin.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    private final Field field;

    private final Figure figure;

    public WinnerController(final Field field, final Figure figure) {
        this.field = field;
        this.figure = figure;
    }

    public Figure getWinner(final Field field) throws InvalidPointException {
        try {
            for(int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1))) {
                    return field.getFigure(new Point(i, 0));
                }
            }
            for(int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(0, i), p -> new Point(p.x + 1, p.y))) {
                    return field.getFigure(new Point(0, i));
                }
            }
            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1))) {
                return field.getFigure(new Point(0, 0));
            }
            if (check(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1))) {
                return field.getFigure(new Point(1, 1));
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field, final Point currentPoint, final IPointGenerator
            pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(currentPoint);
        } catch (final InvalidPointException e) {
            return true;
        }

        if (currentFigure == null) {
            return false;
        }

        if (currentFigure != nextFigure) {
            return false;
        }

        return check(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {
        public Point next(final Point p);
    }
}
