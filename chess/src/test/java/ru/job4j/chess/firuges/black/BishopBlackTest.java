package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void positionTest() {
        BishopBlack bb = new BishopBlack(Cell.A1);
        assertThat(bb.position(), is(Cell.A1));
    }

    @Test
    public void copyTest() {
        BishopBlack bb = new BishopBlack(Cell.A1);
        bb.copy(Cell.A1);
        assertThat(bb.position(), is(Cell.A1));
    }

    @Test
    public void wayTest() {
        BishopBlack bb = new BishopBlack(Cell.B1);
        Cell[] steps = bb.way(Cell.B1, Cell.G6);
        Cell[] result = new Cell[]{Cell.C2, Cell.D3, Cell.E4, Cell.F5, Cell.G6};
        assertThat(steps, is(result));
    }

    @Test
    public void isDiagonal() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        assertThat(bb.isDiagonal(Cell.C1, Cell.G5), is(true));
    }

    @Test
    public void whenInBishopWayAreFigure() {
        Logic logic = new Logic();
        BishopBlack bb = new BishopBlack(Cell.B1);
        BishopBlack bb2 = new BishopBlack(Cell.C2);
        logic.add(bb);
        logic.add(bb2);
        boolean rst = logic.move(Cell.A1, Cell.D3);
        assertThat(rst,is(false));
    }
    @Test
    public void WhenInBishopWayNoFigure() {
        Logic logic = new Logic();
        BishopBlack bb = new BishopBlack(Cell.B1);
        logic.add(bb);
        boolean rst = logic.move(Cell.B1, Cell.D3);
        assertThat(rst,is(true));
    }

}

