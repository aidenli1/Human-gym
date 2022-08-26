package com.spring.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.MyPageDAO;
import com.spring.dto.ExerciseChartDTO;
import com.spring.dto.InbodyDTO;
import com.spring.dto.RoutineDTO;
import com.spring.dto.RecordDTO;

@Service
public class MyPageServiceImpl implements MyPageService{
	
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//인바디
	@Override
	public void inbodyInsert(InbodyDTO dto) throws Exception {
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		dao.inbodyInsert(dto);
	}

	@Override
	public InbodyDTO inbodyDetail(int userNum) throws Exception {
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		return dao.inbodyDetail(userNum);
	}

	@Override
	public void inbodyUpdate(InbodyDTO dto) throws Exception {
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		dao.inbodyUpdate(dto);
	}
	
	
	//운동기록
	@Override
	public RecordDTO recordDetail(RecordDTO getDTO) throws Exception {
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		RecordDTO dto = dao.recordDetail(getDTO);
		return dto;
	};
	@Override
	public void recordInsert(RecordDTO dto) throws Exception{
		
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		dao.recordInsert(dto);
	};

	@Override
	public void recordUpdate(RecordDTO dto) throws Exception{
		
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		dao.recordUpdate(dto);
	};

	@Override
	public void recordDelete(int userNum) throws Exception{
		
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		dao.recordDelete(userNum);
	}

	@Override
	public List<RecordDTO> recordMain(int userNum) throws Exception {
		
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		List<RecordDTO> dtos = dao.recordMain(userNum);
		return dtos;
	};
	
	@Override
	public List<RecordDTO> recordList(int userNum) throws Exception {
		
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		List<RecordDTO> dtos = dao.recordList(userNum);
		return dtos;
	};
	
	@Override
	public List<ExerciseChartDTO> chartData(int userNum) throws Exception {
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		List<ExerciseChartDTO> dtos = dao.chartData(userNum);
		return dtos;
	}
	
	@Override
	public List<ExerciseChartDTO> exList(int userNum) throws Exception{
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		List<ExerciseChartDTO> dtos = dao.exList(userNum);
		return dtos;
	}
	
	@Override
	public List<ExerciseChartDTO> exMain(int userNum) throws Exception{
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		List<ExerciseChartDTO> dtos = dao.exMain(userNum);
		return dtos;
	}
	
	@Override
	public ExerciseChartDTO exNameCount(ExerciseChartDTO chartdto) throws Exception{
		MyPageDAO dao= sqlSession.getMapper(MyPageDAO.class);
		ExerciseChartDTO dto = dao.exNameCount( chartdto);
		return dto;
	}

	@Override
	public void chartInsert(ExerciseChartDTO dto) throws Exception {
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		dao.chartInsert(dto);
		
	}

	@Override
	public ExerciseChartDTO exidSelect(String exname) throws Exception {
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		ExerciseChartDTO dto = dao.exidSelect(exname);
		return dto;
	}
	
	@Override
	public void chartUpdate(ExerciseChartDTO dto) throws Exception {
		MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
		dao.chartUpdate(dto);
		
	}

//	@Override
//	public List<UserRecordDTO> listCriteria(PageMaker pm) throws Exception {
//		MyPageDAO dao=sqlSession.getMapper(MyPageDAO.class);
//		return dao.listCriteria(pm);
//	}
//
//	@Override
//	public int listCount(PageMaker pm) throws Exception {
//		MyPageDAO dao=sqlSession.getMapper(MyPageDAO.class);
//		return dao.listCount(pm);
//	}

//  루틴
  @Override
  public List<RoutineDTO> routineList(int userNum) throws Exception {
     MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
     List<RoutineDTO> dtos = dao.routineList(userNum);
     return dtos;
  }
  
  @Override
  public void routineInsert(RoutineDTO dto) throws Exception {
     MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
     dao.routineInsert(dto);
  }
  
  @Override
  public void routineDelete(int routineNum) throws Exception{
     MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
     dao.routineDelete(routineNum);
  }
     
  @Override
  public void routineUpdate(RoutineDTO dto) throws Exception {
     MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
     dao.routineUpdate(dto);
  }
  
  @Override
  public RoutineDTO routineDetail(int routineNum) throws Exception {
     MyPageDAO dao = sqlSession.getMapper(MyPageDAO.class);
     RoutineDTO dto = dao.routineDetail(routineNum);
     return dto;
  }
}
