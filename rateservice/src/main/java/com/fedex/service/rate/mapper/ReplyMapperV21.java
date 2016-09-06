package com.fedex.service.rate.mapper;

import java.util.List;

import com.fedex.ws.rate.v21.NotificationSeverityType;
import com.fedex.ws.rate.v21.PackagingType;
import com.fedex.ws.rate.v21.RateReply;
import com.fedex.ws.rate.v21.Notification;
import com.fedex.ws.rate.v21.RateReplyDetail;
import com.fedex.ws.rate.v21.ReturnedRateType;
import com.fedex.ws.rate.v21.ServiceIdType;
import com.fedex.ws.rate.v21.ServiceType;
import com.fedex.ws.rate.v21.SignatureOptionType;
import com.fedex.ws.rate.v21.TransactionDetail;
import com.fedex.ws.rate.v21.TransactionSourceFormat;
import com.fedex.ws.rate.v21.VersionId;

public class ReplyMapperV21 {
	
	public RateReply rateReply;
	public RateReply getRateReply( com.fedex.nxgen.crs.v15.ientities.RateReply reply){
		//HigherSeverity
		rateReply.setHighestSeverity(NotificationSeverityType.fromValue(reply.getHighestSeverity()));
		
		//Notification
		List<Notification> notification=rateReply.getNotifications();
		com.fedex.nxgen.crs.v15.ientities.Notification  notify[]=reply.getNotifications();
		for(com.fedex.nxgen.crs.v15.ientities.Notification noti:notify){
			Notification nt=new Notification();
			nt.setCode(noti.getCode());
			nt.setSource(ServiceIdType.fromValue(noti.getSource()));
			nt.setSeverity(NotificationSeverityType.fromValue(noti.getSeverity()));
			nt.setLocalizedMessage(noti.getLocalizedMessage());
			nt.setMessage(noti.getMessage());
			notification.add(nt);
		}
		
		//Transaction Details
		TransactionDetail td=new TransactionDetail();
		td.setCustomerTransactionId(reply.getTransactionDetail().getCustomerTransactionId());
		td.setSourceFormat(TransactionSourceFormat.fromValue(reply.getTransactionDetail().getSourceFormat()));
		rateReply.setTransactionDetail(td);
		//Version
		VersionId vid=new VersionId();
		vid.setServiceId(ServiceIdType.fromValue(reply.getVersion().getServiceId()));
		vid.setMajor(21);
		vid.setMinor(0);
		vid.setIntermediate(0);
		rateReply.setVersion(vid);
		//RateReplyDetails
		List<RateReplyDetail> rateReplyDetailsList=rateReply.getRateReplyDetails();
		com.fedex.nxgen.crs.v15.ientities.RateReplyDetail rrd[]=reply.getRateReplyDetails();
		for(com.fedex.nxgen.crs.v15.ientities.RateReplyDetail rd:rrd){
			RateReplyDetail rateRd=new RateReplyDetail();
			rateRd.setServiceType(ServiceType.fromValue(rd.getServiceType()));
			rateRd.setPackagingType(PackagingType.fromValue(rd.getPackagingType()));
			rateRd.setDestinationAirportId(rd.getDestinationAirportId());
			rateRd.setIneligibleForMoneyBackGuarantee(rd.getIneligibleForMoneyBackGuarantee());
			rateRd.setOriginServiceArea(rd.getOriginServiceArea());
			rateRd.setDestinationServiceArea(rd.getDestinationServiceArea());
			rateRd.setSignatureOption(SignatureOptionType.fromValue(rd.getSignatureOption()));
			rateRd.setActualRateType(ReturnedRateType.fromValue(rd.getActualRateType()));
			/*List<RatedShipmentDetail> rsd=rateRd.getRatedShipmentDetails();
			com.fedex.nxgen.crs.v15.ientities.RatedShipmentDetail rs[]=  rd.getRatedShipmentDetails();
			for(com.fedex.nxgen.crs.v15.ientities.RatedShipmentDetail r:rs){
				RatedShipmentDetail ratesd=new RatedShipmentDetail();
				ratesd.set
			}*/
			rateReplyDetailsList.add(rateRd);
		}
		
		return rateReply;
	}
}
