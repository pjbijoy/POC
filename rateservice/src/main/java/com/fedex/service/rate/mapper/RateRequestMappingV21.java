package com.fedex.service.rate.mapper;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.fedex.nxgen.crs.v15.ientities.Address;
import com.fedex.nxgen.crs.v15.ientities.ClientDetail;
import com.fedex.nxgen.crs.v15.ientities.Dimensions;
import com.fedex.nxgen.crs.v15.ientities.Localization;
import com.fedex.nxgen.crs.v15.ientities.Party;
import com.fedex.nxgen.crs.v15.ientities.RateProcessingOptionsRequested;
import com.fedex.nxgen.crs.v15.ientities.RateRequest;
import com.fedex.nxgen.crs.v15.ientities.RequestedPackageLineItem;
import com.fedex.nxgen.crs.v15.ientities.RequestedShipment;
import com.fedex.nxgen.crs.v15.ientities.ShipmentVariationOptionDetail;
import com.fedex.nxgen.crs.v15.ientities.TransactionDetail;
import com.fedex.nxgen.crs.v15.ientities.VariationOptionDetail;
import com.fedex.nxgen.crs.v15.ientities.VersionId;
import com.fedex.nxgen.crs.v15.ientities.Weight;
import com.fedex.ws.rate.v21.CarrierCodeType;

public class RateRequestMappingV21 {
	RateRequest rateRequest = new RateRequest();
	private static Random random = new Random();
	private static DateFormat dateFormat;
	private static String canonicalHostName;
	private static String shortHost;

	public RateRequest getRateRequest(com.fedex.ws.rate.v21.RateRequest request) {
		// REQUEST MAPPING V21 to v15
		// ApplicationID Mapping
		rateRequest.setApplicationId(request.getApplicationId());
		// Transaction Detail Mapping
		com.fedex.ws.rate.v21.TransactionDetail requestTran = request.getTransactionDetail();
		TransactionDetail td = new TransactionDetail();
		td.setCustomerTransactionId(requestTran.getCustomerTransactionId());
		// getTransDetail(td, "getRates");
		/*
		 * td.setCustomerTransactionId(requestTran.getCustomerTransactionId());
		 * //td.setInternalTransactionId(requestTran.getInternalTransactionId())
		 * ; com.fedex.ws.rate.v21.Localization
		 * reqLoc=requestTran.getLocalization(); Localization loc=new
		 * Localization(); loc.setLanguageCode(reqLoc.getLanguageCode());
		 * loc.setLocaleCode(reqLoc.getLocaleCode()); td.setLocalization(loc);
		 * td.setSourceFormat(requestTran.getSourceFormat().toString());
		 */
		rateRequest.setTransactionDetail(getTransDetail(td, "getRates"));
		// Carrier Code
		List<CarrierCodeType> carrlist = request.getCarrierCodes();
		String[] carrierCode = new String[carrlist.size()];
		int i = 0;
		for (CarrierCodeType ct : carrlist) {
			carrierCode[i] = ct.toString();
		}
		rateRequest.setCarrierCodes(carrierCode);
		// ClientDetails
		ClientDetail clientDetail = new ClientDetail();
		clientDetail.setAccountNumber(request.getClientDetail().getAccountNumber());
		clientDetail.setMeterNumber(request.getClientDetail().getMeterNumber());
		clientDetail.setSoftwareId(request.getClientDetail().getSoftwareId());
		clientDetail.setSoftwareRelease(request.getClientDetail().getSoftwareRelease());
		clientDetail.setUserCredentialKey(request.getClientDetail().getUserCredentialKey());
		rateRequest.setClientDetail(clientDetail);
		// UserDetails
		/*
		 * UserDetail ud=new UserDetail();
		 * ud.setPassword(request.getUserDetail().getPassword());
		 * ud.setUserId(request.getUserDetail().getUserId());
		 * rateRequest.setUserDetail(ud);
		 */

		// Version
		VersionId vi = new VersionId();
		vi.setMajor(15);
		vi.setServiceId(request.getVersion().getServiceId().toString().toLowerCase());
		vi.setIntermediate(request.getVersion().getIntermediate());
		vi.setMinor(request.getVersion().getMinor());
		rateRequest.setVersion(vi);
		// Service Level
		rateRequest.setServiceLevel("EXTERNAL_EDITS");
		// Processing Option
		RateProcessingOptionsRequested po = new RateProcessingOptionsRequested();
		String op[] = new String[1];
		op[0] = request.getProcessingOptions().getOptions().get(0).toString();
		po.setOptions(op);
		rateRequest.setProcessingOptions(po);

		// Supported Option
		VariationOptionDetail vp[] = new VariationOptionDetail[1];
		VariationOptionDetail pv = new VariationOptionDetail();
		pv.setId(request.getSupportedFeatures().get(0).getId());
		String a1[] = new String[1];
		a1[0] = request.getSupportedFeatures().get(0).getValues().get(0);
		pv.setValues(a1);
		vp[0] = pv;
		rateRequest.setSupportedFeatures(vp);

		// RequestedShipement
		RequestedShipment rs = new RequestedShipment();
		Party p = new Party();
		Party p1 = new Party();
		Address a = new Address();
		Address ra1 = new Address();
		a.setCity(request.getRequestedShipment().getShipper().getAddress().getCity());
		a.setStateOrProvinceCode(request.getRequestedShipment().getShipper().getAddress().getStateOrProvinceCode());
		a.setPostalCode(request.getRequestedShipment().getShipper().getAddress().getPostalCode());
		a.setCountryCode(request.getRequestedShipment().getShipper().getAddress().getCountryCode());
		p.setAddress(a);
		ra1.setCity(request.getRequestedShipment().getRecipient().getAddress().getCity());
		ra1.setStateOrProvinceCode(request.getRequestedShipment().getRecipient().getAddress().getStateOrProvinceCode());
		ra1.setPostalCode(request.getRequestedShipment().getRecipient().getAddress().getPostalCode());
		ra1.setCountryCode(request.getRequestedShipment().getRecipient().getAddress().getCountryCode());
		p1.setAddress(ra1);
		rs.setShipper(p);
		rs.setRecipient(p1);
		String rrt[] = new String[1];
		rrt[0] = request.getRequestedShipment().getRateRequestTypes().get(0).toString();
		rs.setRateRequestTypes(rrt);
		rs.setPackageCount(request.getRequestedShipment().getPackageCount().intValue());
		RequestedPackageLineItem rpl[] = new RequestedPackageLineItem[1];
		RequestedPackageLineItem rp = new RequestedPackageLineItem();
		rp.setSequenceNumber(request.getRequestedShipment().getRequestedPackageLineItems().get(0).getSequenceNumber().intValue());
		rp.setGroupPackageCount(request.getRequestedShipment().getRequestedPackageLineItems().get(0).getGroupPackageCount().intValue());
		Weight wt = new Weight();
		wt.setUnits(request.getRequestedShipment().getRequestedPackageLineItems().get(0).getWeight().getUnits().toString());
		wt.setValue(request.getRequestedShipment().getRequestedPackageLineItems().get(0).getWeight().getValue().doubleValue());
		rp.setWeight(wt);
		Dimensions ds = new Dimensions();
		ds.setHeight(request.getRequestedShipment().getRequestedPackageLineItems().get(0).getDimensions().getHeight().intValue());
		ds.setLength(request.getRequestedShipment().getRequestedPackageLineItems().get(0).getDimensions().getLength().intValue());
		ds.setUnits(request.getRequestedShipment().getRequestedPackageLineItems().get(0).getDimensions().getUnits().toString());
		ds.setWidth(request.getRequestedShipment().getRequestedPackageLineItems().get(0).getDimensions().getWidth().intValue());
		rp.setDimensions(ds);
		rpl[0] = rp;
		rs.setRequestedPackageLineItems(rpl);
		ShipmentVariationOptionDetail svo[] = new ShipmentVariationOptionDetail[1];
		ShipmentVariationOptionDetail svod = new ShipmentVariationOptionDetail();
		svod.setId("ISS");
		String val[] = new String[1];
		val[0] = "SUPPORTED";
		svod.setValues(val);
		svo[0] = svod;
		rs.setVariationOptions(svo);
		rateRequest.setRequestedShipment(rs);

		return rateRequest;
	}

	private TransactionDetail getTransDetail(TransactionDetail transDetail, String methodName) {
		transDetail.setSourceFormat("WSI_XML");
		transDetail.setLocalization(getLocalization(transDetail.getLocalization()));

		transDetail.setTracing(false);
		transDetail.setInternalTransactionId(getInternalTransactionID(methodName));

		return transDetail;
	}

	public String getInternalTransactionID(String theMethodName) {
		return doCreateId("wsgw", theMethodName);
	}

	public static final String doCreateId(String paramString1, String paramString2) {
		String str = null;
		getshortHost();
		try {
			str = dateFormat.format(new Date());
		} catch (Exception localException) {
			str = "99999999-00:00:00,000";
		}

		StringBuffer localStringBuffer = new StringBuffer(paramString1).append('-').append(paramString2).append('-')
				.append(shortHost).append('-').append(str).append('-').append(Math.abs(random.nextInt()));
		return localStringBuffer.toString();
	}

	protected Localization getLocalization(Localization loc) {
		if (loc == null) {
			loc = new Localization();
			loc.setLanguageCode("en");
			loc.setLocaleCode("us");
		}

		return loc;
	}

	@SuppressWarnings("unused")
	public RateRequest RequestXsltTransform(com.fedex.ws.rate.v21.RateRequest request) {
		try {
			JAXBContext context = JAXBContext.newInstance();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return rateRequest;
	}

	public static void getshortHost() {
		dateFormat = new SimpleDateFormat("yyyyMMdd-HH:mm:ss,SSS");
		try {
			canonicalHostName = InetAddress.getLocalHost().getCanonicalHostName();
			if ((canonicalHostName == null) || (canonicalHostName.equals(""))) {
				canonicalHostName = "unknown";
			}
		} catch (UnknownHostException localUnknownHostException) {
			canonicalHostName = "unknown";
		}
		int i = canonicalHostName.indexOf('.');
		if (i > 0) {
			shortHost = canonicalHostName.substring(0, canonicalHostName.indexOf('.'));
		} else {
			shortHost = canonicalHostName;
		}
	}
}
