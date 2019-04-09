package game.enemyfollow;

import action.*;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyFollowCreate extends GameObject {
    public Random random;
    public FrameCounter frameCounter;


    public EnemyFollowCreate() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(200);
        this.configAction();
    }

    public void configAction() {
        List<EnemyFollow> enemyFollows_1 = new ArrayList<>();
        List<EnemyFollow> enemyFollows_2 = new ArrayList<>();
        List<EnemyFollow> enemyFollows_3 = new ArrayList<>();
        List<EnemyFollow> enemyFollows_4 = new ArrayList<>();

        Action createAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                EnemyFollow enemyFollow1 = GameObjectManager.instance.recycle(EnemyFollow.class);
                EnemyFollow enemyFollow2 = GameObjectManager.instance.recycle(EnemyFollow.class);
                EnemyFollow enemyFollow3 = GameObjectManager.instance.recycle(EnemyFollow.class);
                EnemyFollow enemyFollow4 = GameObjectManager.instance.recycle(EnemyFollow.class);

                enemyFollows_1.add(enemyFollow1);
                enemyFollows_2.add(enemyFollow2);
                enemyFollows_3.add(enemyFollow3);
                enemyFollows_4.add(enemyFollow4);

                return true;
            }
        };

        Action waitAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                enemyFollows_1.removeIf(enemyFollow1 -> !enemyFollow1.isAlive);
                enemyFollows_2.removeIf(enemyFollow1 -> !enemyFollow1.isAlive);
                enemyFollows_3.removeIf(enemyFollow1 -> !enemyFollow1.isAlive);
                enemyFollows_4.removeIf(enemyFollow1 -> !enemyFollow1.isAlive);
                return true;
            }
        };

        Action setPositionAction1 = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < enemyFollows_1.size(); i++) {
                    enemyFollows_1.get(i).position.set(3200, 2200);
                }
                return true;
            }
        };

        Action setPositionAction2 = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < enemyFollows_2.size(); i++) {
                    enemyFollows_2.get(i).position.set(6100, 2200);
                }
                return true;
            }
        };

        Action setPositionAction3 = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < enemyFollows_3.size(); i++) {
                    enemyFollows_3.get(i).position.set(3200, 5000);
                }
                return true;
            }
        };

        Action setPositionAction4 = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < enemyFollows_4.size(); i++) {
                    enemyFollows_4.get(i).position.set(6100, 5000);
                }
                return true;
            }
        };

        Action moveUpAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < enemyFollows_1.size(); i++) {
                    enemyFollows_1.get(i).velocity.set(0, -5);
                }
                for (int i = 0; i < enemyFollows_2.size(); i++) {
                    enemyFollows_2.get(i).velocity.set(0, -5);
                }
                for (int i = 0; i < enemyFollows_3.size(); i++) {
                    enemyFollows_3.get(i).velocity.set(0, -5);
                }
                for (int i = 0; i < enemyFollows_4.size(); i++) {
                    enemyFollows_4.get(i).velocity.set(0, -5);
                }
                return true;
            }
        };

        Action moveDownAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < enemyFollows_1.size(); i++) {
                    enemyFollows_1.get(i).velocity.set(0, 5);
                }
                for (int i = 0; i < enemyFollows_2.size(); i++) {
                    enemyFollows_2.get(i).velocity.set(0, 5);
                }
                for (int i = 0; i < enemyFollows_3.size(); i++) {
                    enemyFollows_3.get(i).velocity.set(0, 5);
                }
                for (int i = 0; i < enemyFollows_4.size(); i++) {
                    enemyFollows_4.get(i).velocity.set(0, 5);
                }
                return true;
            }
        };

        Action stopAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < enemyFollows_1.size(); i++) {
                    enemyFollows_1.get(i).velocity.set(0, 0);
                }
                for (int i = 0; i < enemyFollows_2.size(); i++) {
                    enemyFollows_2.get(i).velocity.set(0, 0);
                }
                for (int i = 0; i < enemyFollows_3.size(); i++) {
                    enemyFollows_3.get(i).velocity.set(0, 0);
                }
                for (int i = 0; i < enemyFollows_4.size(); i++) {
                    enemyFollows_4.get(i).velocity.set(0, 0);
                }
                return true;
            }
        };

        Action shootAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                EnemyFollowShoot enemyFollowShoot = new EnemyFollowShoot();

                for (int i = 0; i < enemyFollows_1.size(); i++) {
                    enemyFollowShoot.run(enemyFollows_1.get(i));
                }
                for (int i = 0; i < enemyFollows_2.size(); i++) {
                    enemyFollowShoot.run(enemyFollows_2.get(i));
                }
                for (int i = 0; i < enemyFollows_3.size(); i++) {
                    enemyFollowShoot.run(enemyFollows_3.get(i));
                }
                for (int i = 0; i < enemyFollows_4.size(); i++) {
                    enemyFollowShoot.run(enemyFollows_4.get(i));
                }
                return true;
            }
        };

        this.addAction(
                new LimitAction(1,
                        new SequenceAction(
                                createAction, setPositionAction1, setPositionAction2, setPositionAction3, setPositionAction4,
                                new RepeatActionForever(
                                        new SequenceAction(
                                                moveUpAction, new WaitAction(20),
                                                stopAction,new WaitAction(10),
                                                shootAction, new WaitAction(30),
                                                moveDownAction, new WaitAction(70),
                                                stopAction,new WaitAction(10),
                                                shootAction, new WaitAction(30),
                                                moveUpAction, new WaitAction(50),
                                                waitAction)
                                )
                        )
                )
        );
    }
}
