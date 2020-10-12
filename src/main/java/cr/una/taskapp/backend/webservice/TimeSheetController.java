package cr.una.taskapp.backend.webservice;

import cr.una.taskapp.backend.dto.TimeSheetDto;
import cr.una.taskapp.backend.exception.TimeSheetNotFoundException;
import cr.una.taskapp.backend.model.TimeSheet;
import cr.una.taskapp.backend.service.ITimeSheetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Webservice Controller for TimeSheet
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/api/v1/timesheets")
public class TimeSheetController {

    @Autowired
    private ITimeSheetService service;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Find all TimeSheets
     * @return List of DTO TimeSheets
     */
    @GetMapping()
    @ResponseBody
    public List<TimeSheetDto> findAll() {
        List<TimeSheet> roleList = service.findAll();
        return roleList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * Find the timesheet by id
     * Endpoint: /api/v1/timesheets/1
     * @return A timesheet found
     */
    @GetMapping("{id}")
    @ResponseBody
    public TimeSheetDto findById(@PathVariable Long id) throws TimeSheetNotFoundException {
        TimeSheet timesheet = service.findById(id);
        return convertToDto(timesheet);
    }

    /**
     * Save the new TimeSheet
     * @param timesheetDto the timesheet saved
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TimeSheetDto save(@Valid @RequestBody TimeSheetDto timesheetDto) {
        TimeSheet timesheet = convertToEntity(timesheetDto);
        return convertToDto(service.create(timesheet));
    }

    /**
     * Calcula el pago
     * Endpoint: /api/v1/timesheets/time/{userID}
     * @return A timesheet found
     */
//    @GetMapping("{userID}")
//    @ResponseBody
//    public String ratePayment(@PathVariable Long id) {
//        Long tiempo;
//        String time;
//        TimeSheet timesheet = service.findById(id);
//        tiempo=timesheet.getFriday()+ timesheet.getMonday();
//        time= ("ratepayment: "+ tiempo);
//        return time;
//    }



    /**
     * Update the existing TimeSheet
     * @param timesheetDto the timesheet saved
     * @return the timesheet updated
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TimeSheetDto update(@Valid @RequestBody TimeSheetDto timesheetDto) {
        TimeSheet timesheet = convertToEntity(timesheetDto);
        return convertToDto(service.update(timesheet));
    }

    /**
     * Delete user by id
     * @param id the id of the entity
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
        try {
            service.deleteById(id);
        } catch (TimeSheetNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT, "Priority Not Found", ex);
        }
    }
    
    /**
     * Convert from Entity to DTO
     * @param timesheet entity
     * @return the DTO
     */
    private TimeSheetDto convertToDto(TimeSheet timesheet) {
        TimeSheetDto timesheetDto = modelMapper.map(timesheet, TimeSheetDto.class);
        return timesheetDto;
    }

    /**
     * Convert from DTO to Entity
     * @param timesheetDto the DTO
     * @return the entity
     */
    private TimeSheet convertToEntity(TimeSheetDto timesheetDto) {
        TimeSheet timesheet = modelMapper.map(timesheetDto, TimeSheet.class);
        return timesheet;
    }
}