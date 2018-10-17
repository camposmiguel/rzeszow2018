import { Entity, Column, PrimaryGeneratedColumn, ManyToMany, JoinTable, OneToMany, ManyToOne } from 'typeorm';
import { Battle } from 'battle/battle.entity';
import { Exercise } from 'exercise/exercise.entity';

@Entity()
export class User {
  @PrimaryGeneratedColumn('increment') id: number;

  @Column({ length: 100 })
  username: string;

  @Column() email: string;

  @Column() password: string;

  @Column({default: 0})
  points: number;

  @OneToMany(type => Battle, battle => battle.user1)
  myBattles: Battle[];

  @OneToMany(type => Battle, battle => battle.user2)
  otherBattles: Battle[];

  @ManyToMany(type => Exercise)
  @JoinTable()
  categories: Exercise[];

}