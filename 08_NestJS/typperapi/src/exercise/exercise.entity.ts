import { Entity, Column, PrimaryGeneratedColumn, ManyToMany, JoinTable, OneToMany, ManyToOne } from 'typeorm';

@Entity()
export class Exercise {
  @PrimaryGeneratedColumn('increment') id: number;

  @Column()
  title: string;

  @Column() text: string;

  @Column() order: number;

}