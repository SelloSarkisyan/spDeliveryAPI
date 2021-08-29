package com.bonyansystem.spdeliveryapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

//defining the path of request and entry variables
@Path("/insert-delivery/id={id}&daykey={daykey}&delid={deliveryId}&msisdn={msisdn}&part={part}&opstat={opStat}&stat={stat}")
public class ApiEntry {
	@GET
	@Produces("text/plain")
	//get entry variables and passing to Database as an entity
	public String insertDelivery(@PathParam("id") int id, @PathParam("daykey") int daykey,
                                 @PathParam("deliveryId") int deliveryId,
                                 @PathParam("msisdn") int msisdn, @PathParam("part") int part,
                                 @PathParam("opStat") int op, @PathParam("stat") String stat) {
		try {
			DeliveryEntity delivery = new DeliveryEntity(id, daykey, deliveryId, msisdn, part, op, stat);

			DbService insertion = new DbService();
			insertion.insertEntity(delivery);

			return "DONE";
		}
		catch (Exception e){
			return  "Insertion Failed";
		}
	}
}
