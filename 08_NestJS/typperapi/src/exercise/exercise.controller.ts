import { Controller, Get, Res, HttpStatus } from '@nestjs/common';
import { ExerciseService } from './exercise.service';

@Controller('exercise')
export class ExerciseController {

    constructor(private exerciseService: ExerciseService) {
    }

    @Get('/all')
    getAllUsers(@Res() res) {
        this.exerciseService.getAll().then(exerciseList => {
          res.status(HttpStatus.OK).json(exerciseList);
        });
    }

}
