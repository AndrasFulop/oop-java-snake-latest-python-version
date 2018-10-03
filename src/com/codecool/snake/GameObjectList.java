package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import javafx.scene.layout.Pane;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GameObjectList {
    private Pane pane;
    private List<GameEntity> gameObjects = new LinkedList<>();
    private List<GameEntity> newGameObjects = new LinkedList<>();// Holds game objects crated in this frame.
    private List<GameEntity> oldGameObjects = new LinkedList<>();// Holds game objects that will be destroyed this frame.

    GameObjectList(Pane pane) {this.pane = pane;}

    public void addGameObject(GameEntity toAdd) {
        newGameObjects.add(toAdd);
        pane.getChildren().add(toAdd);
    }

    public void removeGameObject(GameEntity toRemove) {
        oldGameObjects.add(toRemove);
    }

    public List<GameEntity> getGameObjects() {
        return Collections.unmodifiableList(gameObjects);
    }

    public void frameFinished() {
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();

        for(GameEntity entity : oldGameObjects) {
            pane.getChildren().remove(entity);
        }
        gameObjects.removeAll(oldGameObjects);
        oldGameObjects.clear();
    }

}
