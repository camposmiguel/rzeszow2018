import { Entity, Column, PrimaryGeneratedColumn, ManyToMany, JoinTable, OneToMany, ManyToOne } from 'typeorm';
import { Level } from 'level/level.entity';

@Entity()
export class Exercise {
  @PrimaryGeneratedColumn('increment') id: number;

  @Column()
  title: string;

  @Column() text: string;

  @Column() order: number;

  @ManyToOne(type => Level, level => level.exercises)
  level: Level;

}