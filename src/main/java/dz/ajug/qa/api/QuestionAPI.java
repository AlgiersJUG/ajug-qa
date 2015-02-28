package dz.ajug.qa.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dz.ajug.qa.dao.QuestionDAO;
import dz.ajug.qa.model.Question;

@Path("/question")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionAPI {

	@Inject
	QuestionDAO dao;

	@GET
	@Path("/all")
	public List<Question> list() {
		return dao.getAll();
	}

	@GET
	@Path("/search/{str}")
	public List<Question> list(@PathParam("str") String str) {
		return dao.getByString(str);
	}

	@GET
	@Path("/{id}")
	public Question get(@PathParam("id") String id) {
		return dao.getOne(Long.valueOf(id));
	}

	@POST
	public Question save(Question question) {
		if (question != null && question.getId() != null) {
			return dao.update(question);
		} else {
			return dao.insert(question);
		}
	}

	@PUT
	public Question update(Question question) {

		return dao.update(question);
	}

	@DELETE
	@Path("/{id}")
	public void remove(@PathParam("id") Long id) {

		dao.remove(id);
	}

}
