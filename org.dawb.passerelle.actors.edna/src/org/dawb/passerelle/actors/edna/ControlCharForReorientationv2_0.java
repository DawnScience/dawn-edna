/*
 * Copyright (c) 2012 European Synchrotron Radiation Facility,
 *                    Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.dawb.passerelle.actors.edna;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

/**
 * ControlCharForReorientationv2_0
 * 
 * @author svensson
 * @date March 23, 2011
 * @project org.edna.passerelle.actors
 **/
public class ControlCharForReorientationv2_0 extends AbstractEdnaPlugin {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6909806600920182932L;
	/**
	 * 
	 */
	private final static Logger logger = LoggerFactory.getLogger(ControlCharForReorientationv2_0.class);

	/**
	 * 
	 */

	public ControlCharForReorientationv2_0(CompositeEntity container, String name)
			throws NameDuplicationException, IllegalActionException {
		super("EDPluginControlCharForReorientationv2_0", container, name);

	}
	
	@Override
	protected String getInputTagName() {
		return "XSDataInputCharacterisationv2_0";
	}

	@Override
	protected String getSchemaLocation() {
		return "mxv2/datamodel/XSDataMXv2.xsd";
	}

	@Override
	protected String getPythonLocation() {
		return "mxv2/plugins/EDPluginControlCharForReorientation-v2.0/plugins/EDPluginControlCharForReorientationv2_0.py";
	}

	@Override
	protected String getExampleOutputLocation() {
		return "mxv2/plugins/EDPluginControlCharForReorientation-v2.0/tests/data/XSDataResultCharacterisationv2_0_reference.xml";
	}

	@Override
	public String getExtendedInfo() {
		return "MXv2 Char For Reorientation";
	}

	@Override
	public String getDefaultInputXML() {

		final StringBuilder buf = new StringBuilder();

		buf.append("<?xml version=\"1.0\" ?>\n");
		buf.append("<XSDataInputCharacterisationv2_0>\n");
		buf.append("  <mxv1InputCharacterisation>\n");
		buf.append("    <dataCollection>\n");
		buf.append("      <diffractionPlan>\n");
		buf.append("        <kappaStrategyOption>\n");
		buf.append("      	  <value>Cell</value>\n");
		buf.append("        </kappaStrategyOption>\n");
		buf.append("        <maxExposureTimePerDataCollection>\n");
		buf.append("          <value>1000.000000</value>\n");
		buf.append("        </maxExposureTimePerDataCollection>\n");
		buf.append("        <complexity>\n");
		buf.append("      	  <value>full</value>\n");
		buf.append("        </complexity>\n");
		buf.append("      </diffractionPlan>\n");
		buf.append("      ${sub_wedges}\n");
		buf.append("    </dataCollection>\n");
		buf.append("  </mxv1InputCharacterisation>\n");
		buf.append("  <mxv2DataCollection>\n");
		buf.append("     <XSSubWedge>\n");
		buf.append("        <imagefilenametemplate>\n");
		buf.append("            <value>ref-testscale_1_###.img</value>\n");
		buf.append("        </imagefilenametemplate>\n");
		buf.append("        <XSBeamSetting>\n");
		buf.append("            <wavelength>\n");
		buf.append("                <value>1.000000e+00</value>\n");
		buf.append("            </wavelength>\n");
		buf.append("            <XSBeam>\n");
		buf.append("                <polarisatation>\n");
		buf.append("                    <v1>0.000000e+00</v1>\n");
		buf.append("                    <v2>1.000000e+00</v2>\n");
		buf.append("                    <v3>0.000000e+00</v3>\n");
		buf.append("				</polarisatation>\n");
		buf.append("                <direction>\n");
		buf.append("                    <v1>1.000000e+00</v1>\n");
		buf.append("                    <v2>0.000000e+00</v2>\n");
		buf.append("                    <v3>0.000000e+00</v3>\n");
		buf.append("				</direction>\n");
		buf.append("            </XSBeam>\n");
		buf.append("        </XSBeamSetting>\n");
		buf.append("        <XSDiffractionImages>\n");
		buf.append("            <filename>\n");
		buf.append("                <value>/home/sudol/work/ednanew/ref-testscale_1_002.img</value>\n");
		buf.append("            </filename>\n");
		buf.append("        </XSDiffractionImages>\n");
		buf.append("        <XSRotationalGoniostatSetting>\n");
		buf.append("            <baseaxissetting>\n");
		buf.append("                <value>0.000000e+00</value>\n");
		buf.append("			</baseaxissetting>\n");
		buf.append("            <axissetting>\n");
		buf.append("                <value>9.000000e+01</value>\n");
		buf.append("			</axissetting>\n");
		buf.append("            <axissetting>\n");
		buf.append("                <value>4.000000e+01</value>\n");
		buf.append("			</axissetting>\n");
		buf.append("            <XSRotationalGoniostat>\n");
		buf.append("                <XSGoniostatBaseAxis>\n");
		buf.append("                    <isscannable>\n");
		buf.append("                        <value>1</value>\n");
		buf.append("                    </isscannable>\n");
		buf.append("                    <name>\n");
		buf.append("                        <value>Omega</value>\n");
		buf.append("                    </name>\n");
		buf.append("                    <XSCalibratedDisplacementAxis>\n");
		buf.append("                        <zerodirection>\n");
		buf.append("                            <v1>0.000000e+00</v1>\n");
		buf.append("                            <v2>0.000000e+00</v2>\n");
		buf.append("                            <v3>1.000000e+00</v3>\n");
		buf.append("						</zerodirection>\n");
		buf.append("                        <XSCalibration>\n");
		buf.append("                            <date>\n");
		buf.append("	                           <value>2009-12-10</value>\n");
		buf.append("                            </date>\n");
		buf.append("                        </XSCalibration>\n");
		buf.append("                    </XSCalibratedDisplacementAxis>\n");
		buf.append("				</XSGoniostatBaseAxis>\n");
		buf.append("                <XSGoniostatRotatableAxis>\n");
		buf.append("                    <isscannable>\n");
		buf.append("                        <value>0</value>\n");
		buf.append("                    </isscannable>\n");
		buf.append("                    <name>\n");
		buf.append("                        <value>Kappa</value>\n");
		buf.append("                    </name>\n");
		buf.append("                    <XSCalibratedDisplacementAxis>\n");
		buf.append("                        <zerodirection>\n");
		buf.append("                            <v1>0.000000e+00</v1>\n");
		buf.append("                            <v2>7.071068e-01</v2>\n");
		buf.append("                            <v3>7.071068e-01</v3>\n");
		buf.append("						</zerodirection>\n");
		buf.append("                        <XSCalibration>\n");
		buf.append("                            <date>\n");
		buf.append("	                           <value>2009-12-10</value>\n");
		buf.append("                            </date>\n");
		buf.append("                        </XSCalibration>\n");
		buf.append("                    </XSCalibratedDisplacementAxis>\n");
		buf.append("				</XSGoniostatRotatableAxis>\n");
		buf.append("                <XSGoniostatRotatableAxis>\n");
		buf.append("                    <isscannable>\n");
		buf.append("                        <value>0</value>\n");
		buf.append("                    </isscannable>\n");
		buf.append("                    <name>\n");
		buf.append("                        <value>Phi</value>\n");
		buf.append("                    </name>\n");
		buf.append("                    <XSCalibratedDisplacementAxis>\n");
		buf.append("                        <zerodirection>\n");
		buf.append("                            <v1>0.000000e+00</v1>\n");
		buf.append("                            <v2>0.000000e+00</v2>\n");
		buf.append("                            <v3>1.000000e+00</v3>\n");
		buf.append("						</zerodirection>\n");
		buf.append("                        <XSCalibration>\n");
		buf.append("                            <date>\n");
		buf.append("	                           <value>2009-12-10</value>\n");
		buf.append("                            </date>\n");
		buf.append("                        </XSCalibration>\n");
		buf.append("                    </XSCalibratedDisplacementAxis>\n");
		buf.append("				</XSGoniostatRotatableAxis>\n");
		buf.append("            </XSRotationalGoniostat>\n");
		buf.append("        </XSRotationalGoniostatSetting>\n");
		buf.append("        <XSRotationExposure>\n");
		buf.append("           <imagewidth>\n");
		buf.append("               <value>1.000000e+00</value>\n");
		buf.append("			</imagewidth>\n");
		buf.append("           <numberimages>\n");
		buf.append("                <value>1</value>\n");
		buf.append("            </numberimages>\n");
		buf.append("            <exposuretime>\n");
		buf.append("                <value>1.000000e+00</value>\n");
		buf.append("            </exposuretime>\n");
		buf.append("        </XSRotationExposure>\n");
		buf.append("    </XSSubWedge>\n");
		buf.append("  </mxv2DataCollection>\n");
		buf.append("</XSDataInputCharacterisationv2_0>\n");
		return buf.toString();
	}

	@Override
	public Properties getDefaultOutputProperties() {
		final Properties props = new Properties();
		props.put("suggestedStrategy", "//suggestedStrategy");
		props.put("possibleOrientations", "//possibleOrientations");
		return props;
	}

}
