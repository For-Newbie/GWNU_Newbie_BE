package kr.ac.gwnu.gwnu_newbie.graduate.application;

import kr.ac.gwnu.gwnu_newbie.graduate.domain.Graduate;
import kr.ac.gwnu.gwnu_newbie.graduate.domain.GraduateDetail;
import kr.ac.gwnu.gwnu_newbie.graduate.domain.LiberalArtsCredit;
import kr.ac.gwnu.gwnu_newbie.graduate.domain.MajorCredit;
import kr.ac.gwnu.gwnu_newbie.graduate.domain.dto.GraduateResponseDto;
import kr.ac.gwnu.gwnu_newbie.graduate.domain.dto.GraduateListResponseDto;
import kr.ac.gwnu.gwnu_newbie.graduate.domain.dto.LiberalArtsDto;
import kr.ac.gwnu.gwnu_newbie.graduate.domain.dto.MajorDto;
import kr.ac.gwnu.gwnu_newbie.graduate.domain.repository.GraduateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GraduateService {

    private final GraduateRepository graduateRepository;

    public GraduateListResponseDto getAllGraduateRequirements() {
        List<Graduate> graduates = graduateRepository.findAll();

        List<GraduateResponseDto> graduateResponseDtos = graduates.stream()
                .map(this::convertToDto)
                .toList();

        return GraduateListResponseDto.of(graduateResponseDtos);
    }

    public GraduateResponseDto getGraduateRequirements(String major, Integer classOf) {
        Graduate graduate = graduateRepository.findByMajorAndClassOf(major, classOf)
                .orElseThrow(() -> new RuntimeException("해당 학과의 졸업요건을 찾을 수 없습니다."));

        return convertToDto(graduate);
    }

    private GraduateResponseDto convertToDto(Graduate graduate) {
        GraduateDetail detail = graduate.getGraduateDetail();
        LiberalArtsCredit liberalArtsCredit = detail.getLiberalArtsCredit();
        MajorCredit majorCredit = detail.getMajorCredit();

        Integer basicLiberal = getBasicLiberal(liberalArtsCredit);
        Integer balanceLiberal = liberalArtsCredit.getBalanceLiberal();
        Integer specialLiberal = liberalArtsCredit.getSpecialLiberal();
        Integer liberalTotal = basicLiberal + balanceLiberal + specialLiberal;

        LiberalArtsDto liberalArtsDto = LiberalArtsDto.of(
                basicLiberal,
                balanceLiberal,
                specialLiberal,
                liberalTotal
        );

        Integer basicMajor = majorCredit.getBasicMajor();
        Integer requireMajor = majorCredit.getRequireMajor();
        Integer selectMajor = majorCredit.getSelectMajor();
        Integer majorTotal = basicMajor + requireMajor + selectMajor;

        MajorDto majorDto = MajorDto.of(
                basicMajor,
                requireMajor,
                selectMajor,
                majorTotal
        );

        return GraduateResponseDto.of(
                graduate.getId(),
                graduate.getClassOf(),
                graduate.getMajor(),
                liberalArtsDto,
                majorDto,
                detail.getTeachingSubjects(),
                detail.getCredit(),
                130
        );
    }

    private static Integer getBasicLiberal(LiberalArtsCredit liberalArtsCredit) {
        return liberalArtsCredit.getBasicLiberal();
    }
}