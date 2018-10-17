import { Entity, Column, PrimaryGeneratedColumn, ManyToMany, JoinTable, OneToMany, ManyToOne } from 'typeorm';
import { Exercise } from 'exercise/exercise.entity';

@Entity()
export class Level {
  @PrimaryGeneratedColumn('increment') id: number;

  @Column()
  name: string;

  @Column() order: number;

  @OneToMany(type => Exercise, exercise => exercise.level) // note: we will create level property in the Exercise class below
  exercises: Exercise[];

}