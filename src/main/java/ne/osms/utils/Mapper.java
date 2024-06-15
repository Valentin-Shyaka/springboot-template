package ne.osms.utils;

import ne.osms.models.User;
import org.modelmapper.ModelMapper;

public class Mapper {

    public static ModelMapper modelMapper = new ModelMapper();

    public static User getUserFromDTO(Object object) {
        return modelMapper.map(object, User.class);
    }


}
