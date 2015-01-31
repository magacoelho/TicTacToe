package es.art83.ticTacToe.controllers;

import java.util.List;

import es.art83.ticTacToe.models.entities.CoordinateEntity;
import es.art83.ticTacToe.models.utils.ColorModel;

public interface ShowGameController {

    String getNameGame();

    ColorModel[][] colors();

    boolean gameOver();

    ColorModel winner();

    boolean savedGame();

    ColorModel turnColor();

    boolean hasAllPieces();

    List<CoordinateEntity> validSourceCoordinates();

    List<CoordinateEntity> validDestinationCoordinates();

    boolean createdGame();

}
