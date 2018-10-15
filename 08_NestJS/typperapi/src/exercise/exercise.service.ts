import { Injectable } from '@nestjs/common';
import { Exercise } from './exercise.entity';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';

@Injectable()
export class ExerciseService {
    constructor(
        @InjectRepository(Exercise)
        private readonly exerciseRepository: Repository<Exercise>,
      ) {}

      /*******************************************************
       * Get all Exercises
       *******************************************************/
      async getAll(): Promise<Exercise[]> {
        return await this.exerciseRepository.find();
      }
}
